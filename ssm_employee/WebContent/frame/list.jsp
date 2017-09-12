<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>


<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#999"> 部门管理</td>
</tr>
</table>

<br/>

<table cellspacing="0" border="1" class="table1">
<thead>
   <tr><th width="450">部门名称</th><th  width="450">编辑</th></tr>
</thead>
<tbody>
<s:iterator value="list" var="d">
<tr>
<td align="center"><s:property value="#d.dname"/></td>
<td align="center"><a href="${pageContext.request.contextPath }/department_saveUI.action">添加</a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span><s:property value="currPage"/>/<s:property value="totalCount"/>页</span>
   <span>
       <a href="${pageContext.request.contextPath }/department_findAll?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </span>
</td>
</tr>
</table>
</body>
</html>