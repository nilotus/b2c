function grid1() {
    alert("111111");
    $.ajax({
        type: 'get',
        async: true,
        dataType: 'json',
        success: function (msg) {
            if (!msg.res) {
                if (msg.type == "active") {
                    var str = '<tr class="active">\
							<td>' + msg.订单号 + '</td>\
							<td>' + msg.日期 + '</td>\
							<td>待发货</td>\
							<td>' + msg.地址 + '</td>\
							<td>' + msg.价格 + '</td>\
						</tr>';
                    $('.dingdan').append(str);
                }
                if (msg.type == "success") {
                    var str = '<tr class="success">\
							<td>' + msg.订单号 + '</td>\
							<td>' + msg.日期 + '</td>\
							<td>发货中</td>\
							<td>' + msg.地址 + '</td>\
							<td>' + msg.价格 + '</td>\
						</tr>';
                    $('.dingdan').append(str);
                }
                if (msg.type == "warning") {
                    var str = '<tr class="warning">\
							<td>' + msg.订单号 + '</td>\
							<td>' + msg.日期 + '</td>\
							<td>待确认</td>\
							<td>' + msg.地址 + '</td>\
							<td>' + msg.价格 + '</td>\
						</tr>';
                    $('.dingdan').append(str);
                }
                if (msg.type == "danger") {
                    var str = '<tr class="danger">\
							<td>' + msg.订单号 + '</td>\
							<td>' + msg.日期 + '</td>\
							<td>已退货</td>\
							<td>' + msg.地址 + '</td>\
							<td>' + msg.价格 + '</td>\
						</tr>';
                    $('.dingdan').append(str);
                }
            }
            alert("success");
        },
        error: function () {
            alert("failed!");
        }
    });
}

$.ajax({
    type: 'get',
    async: true,
    dataType: 'json',
    success: function (msg) {
        if (!msg.res) {

            var str = '<tr>\
						<td>' + msg.ID + '</td>\
						<td>' + msg.用户名 + '</td>\
						<td>' + msg.电话 + '</td>\
						<td>' + msg.日期 + '</td>\
						</tr>';
            $('.yonghu').append(str);
        }
        alert("success");
    },
    error: function () {
        alert("failed!");
    }
});

