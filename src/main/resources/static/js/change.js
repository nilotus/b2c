
function change1() {
			 
			document.getElementById("grid1").style.display = "block";
			document.getElementById("grid2").style.display = "none";
			document.getElementById("grid3").style.display = "none";
			document.getElementById("grid4").style.display = "none";
			
			
//				$.ajax({
//					type:'get',
//					async:true,
//					dataType:'json',
//					success:function(msg){
//						if (!msg.res){
//							if (msg.type == "active"){
//								var str = '<tr class="active">
//											<td>'+msg.订单号+'</td>
//											<td>'+msg.日期+'</td>
//											<td>待发货</td>
//											<td>'+msg.地址+'</td>
//											<td>'+msg.价格+'</td>
//										</tr>';
//								$('.dingdan').append(str);
//							}
//							if (msg.type == "success"){
//								var str = '<tr class="success">
//											<td>'+msg.订单号+'</td>
//											<td>'+msg.日期+'</td>
//											<td>发货中</td>
//											<td>'+msg.地址+'</td>
//											<td>'+msg.价格+'</td>
//										</tr>';
//								$('.dingdan').append(str);
//							}
//							if (msg.type == "warning"){
//								var str = '<tr class="warning">
//											<td>'+msg.订单号+'</td>
//											<td>'+msg.日期+'</td>
//											<td>待确认</td>
//											<td>'+msg.地址+'</td>
//											<td>'+msg.价格+'</td>
//										</tr>';
//								$('.dingdan').append(str);		
//							}
//							if (msg.type == "danger"){
//								var str = '<tr class="danger">
//											<td>'+msg.订单号+'</td>
//											<td>'+msg.日期+'</td>
//											<td>已退货</td>
//											<td>'+msg.地址+'</td>
//											<td>'+msg.价格+'</td>
//										</tr>';
//								$('.dingdan').append(str);	
//							}
//						}
//						alert("success");
//					}
//					error: function() {
//							alert("failed!");	
//						}
//			});
		}

function change2() {
			 
			document.getElementById("grid1").style.display = "none";
			document.getElementById("grid2").style.display = "block";
			document.getElementById("grid3").style.display = "none";
			document.getElementById("grid4").style.display = "none";
		}

function change3() {
			 
			document.getElementById("grid1").style.display = "none";
			document.getElementById("grid2").style.display = "none";
			document.getElementById("grid3").style.display = "block";
			document.getElementById("grid4").style.display = "none";

		}

function change4() {
			 
			document.getElementById("grid1").style.display = "none";
			document.getElementById("grid2").style.display = "none";
			document.getElementById("grid3").style.display = "none";
			document.getElementById("grid4").style.display = "block";
		}