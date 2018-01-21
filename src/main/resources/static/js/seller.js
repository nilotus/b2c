$(function() {

	var myChart = echarts.init(document.getElementById('main'));
	
	option = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				crossStyle: {
					color: '#999'
				}
			}
		},
		toolbox: {
			feature: {
				dataView: {
					show: true,
					readOnly: false
				},
				magicType: {
					show: true,
					type: ['line', 'bar']
				},
				restore: {
					show: true
				},
				saveAsImage: {
					show: true
				}
			}
		},
		legend: {
			data: ['交易量', '销售额' ]
		},
		xAxis: [{
			type: 'category',
			data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
			axisPointer: {
				type: 'shadow'
			}
		}],
		yAxis: [{
			type: 'value',
			name: '交易量',
			min: 0,
			max: 250,
			interval: 50,
			axisLabel: {
				formatter: '{value} 件'
			}
		}, {
			type: 'value',
			name: '销售额',
			min: 0,
			max: 20000,
			interval: 1000,
			axisLabel: {
				formatter: '{value} rmb'
			}
		}],
		series: [{
			name: '交易量',
			type: 'bar',
			data: [20, 60, 80,  60, 120, 240, 100, 20, 32.6, 20.0, 63, 33]
		}, {
			name: '销售额',
			type: 'bar',
			data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
		}, ]
	};
    myChart.setOption(option);
});
	