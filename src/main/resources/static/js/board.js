let index={
    init:function () {
        $("#btn-save").on("click", () => {
            this.save();
        });

    },
    save:function() {
        // ('board save함수 호출됨;')
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
            location.href="index.html"
        }).fail(function (error){
                alert((JSON.stringify(error)))
            }
        )
    }
}
index.init();