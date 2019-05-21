（1） 图片列表分页插件

	图片分页插件，支持本地js数组分页加载和ajax服务器端加载。
	图片有多种展示动画效果，主要用到了animate.min.css，如不需要，可以去掉animate.min.css引用。

（2）效果


（3）引用
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/animate.css/3.5.2/animate.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <link href="css/imgDataGrid.css" rel="stylesheet" />
    <script src="js/imgDataGrid.js"></script>



（4）网页标签
    <div id="imgDataGrid"> </div>

（5）js初始化
	js加载数据有两种方式：

	（5.1）本地分页加载	
		//本地分页加载	
		function cmsImgLocalSearch(){
			var data = {
				"page": 1,//当前页码
				"records": 19,//总条数
				"rows": [{ "Id": 1, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 2, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 3, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 4, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 5, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 6, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 7, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 8, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 9, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 10, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 11, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 12, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" },
						{ "Id": 13, "materialThumUriPath": "http://112.124.8.234:8090/chcedo/ueditor/jsp/upload/image/20180724/1532417595486074835.png" }                   
				]
			};
			$('#imgDataGrid').imgDataGrid({
				title: '图片集',
				type: 'GET',//GET|POST
				data:data,//本地数据
				params: { type: 0 },//url参数
				height: '400px',
				width: '1000px',
				img: { width: '180px',height: '180px', animate: 'zoomIn' },//图片宽度，及动画效果
				onClick: function (obj, index, item) {//点击图片事件
					alert(index);
				},
				render: function (item, index) {//自定义显示图片
					var str = '<div style="width: 100px; height: 100px;margin:0 auto;">'+
						'<img src="' + item.materialThumUriPath + 
						'"class="img_material"></div ><div style="width: 170px; height: 70px;word-wrap: break-word;margin:0 auto;text-align: center;">'
						+item.Id+'</div>';
					return str;
				}
			});	
		}
        		
   （5.2）ajax从服务器分页加载      
	    //ajax从服务器分页加载	代码不全，仅供参考
		/*
		function cmsImgSearch(){	
			var param = $("#cmsImgInfo").serialize();
			var materialName = $("#materialName").val();
			var useScene = $("#useScene").val();

				$('#imgDataGrid').imgDataGrid({
					title: '图片集',
					type:'POST',//GET|POST
					async:false,
					dataType:"json",
					url: '${rc.contextPath}/article/${systemId}/searchCmsMaterial.json',//url
					params: { materialName: materialName,useScene:useScene },//url参数  				
					height: '400px',
					width: '1000px',
					img: { width: '180px',height: '180px', animate: 'zoomIn' },//图片宽度，及动画效果
					onClick: function (obj,index, item) { //点击图片事件
						  InsertHTMLPic(item.materialUriPath) ;
						  $('#showCmsPicModel').modal('hide');
					},
					render: function (item, index) {//自定义显示图片	            	
						var str = '<div style="width: 100px; height: 100px;margin:0 auto;">'+'<img src="' + item.materialThumUriPath + '"class="img_material"></div ><div style="width: 170px; height: 70px;word-wrap: break-word;margin:0 auto;text-align: center;">'+item.materialName+'</div>';
						return str;
					}
				});
		}
		*/

