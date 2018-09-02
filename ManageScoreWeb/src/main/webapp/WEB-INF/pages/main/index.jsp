<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
<!-- 引入样式 -->
<link rel="stylesheet"
	href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">

</head>
<body>

	This is my main page!

	<div id="app">
		<el-button @click="visible = true">Button</el-button>
		<el-dialog :visible.sync="visible" title="Hello world">
		<p>Try Element</p>
		</el-dialog>
	</div>


</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script>
	new Vue({
		el : '#app',
		data : function() {
			return {
				visible : false
			}
		}
	})
</script>
</html>