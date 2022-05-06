let index={
    init:function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-reply-save").on("click", () => {
            this.replySave();
        });
    },
    save:function() {
        let data={
            title:$("#title").val(),
            content:$("#content").val()

        }
        console.log(data)
        $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("등록완료 완료");
            location.href="/"
        }).fail(function (error){
                alert((JSON.stringify(error)))
            }
        )
    },

    deleteById:function() {
        let id = $("#id").val();
        $.ajax({
            type:"DELETE",
            url:"/api/board/"+id,
            dataType:"json"
        }).done(function(resp){
            alert("삭제완료 완료 id:"+id);
            location.href="/"
        }).fail(function (error){
                alert((JSON.stringify(error)))
            }
        )
    },
    update:function() {
        let id = $("#id").val();
        let data={
            title:$("#title").val(),
            content:$("#content").val()
        }
        $.ajax({
            type:"PUT",
            url:"/api/board/"+id,
            data:JSON.stringify(data),
            contentType:"application/json; carset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("글 수정 완료 id:"+id);
            location.href="/"
        }).fail(function (error){
                alert((JSON.stringify(error)))
            }
        )
    },
    replySave:function() {
        let data={
            userId:$("#userId").val(),
            boardId:$("#boardId").val(),
            content:$("#reply-content").val()
        }
        console.log(data)
        $.ajax({
            type:"POST",
            url:"/api/board/"+data.boardId+"/reply",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("댓글 작성 완료");
            alert(data.boardId);
            alert(data.content);
            location.href="/board/"+data.boardId;
        }).fail(function (error){
                alert((JSON.stringify(error)))
            }
        )
    },
    replyDelete:function() {
        let data={
            userId:$("#userId").val(),
            boardId:$("#boardId").val(),
            content:$("#reply-content").val()
        }
        console.log(data)
        $.ajax({
            type:"POST",
            url:"/api/board/"+data.boardId+"/reply",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("댓글 작성 완료");
            alert(data.boardId);
            alert(data.content);
            location.href="/board/"+data.boardId;
        }).fail(function (error){
                alert((JSON.stringify(error)))
            }
        )
    },
}
index.init();