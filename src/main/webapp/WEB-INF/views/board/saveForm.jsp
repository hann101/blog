<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp"%>


<div class="container">
        <form>
                <div class="form-group">
                        <label for="title"> 제목</label>
                        <input type="text" class="form-control" placeholder="Enter title" id="title">
                </div>
                <div class="form-group">
                        <label for="content">Comment:</label>
                        <textarea class="form-control summernote" rows="5" id="content"></textarea>
                </div>
        </form>
        <button id="btn-save" class="btn btn-primary">등록</button>
<%--form 안에 있을때 alert안뜸 이유는..?--%>
</div>
<script>
        $('.summernote').summernote({
                tabsize: 2,
                height: 100
        });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>
