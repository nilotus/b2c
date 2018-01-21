function slideProduct(a,b){
	this.container=$(a);
	this.mask=$("#newprd-img-b");
	this.link=$("#newprd-img-b-a");
	this.maskBg=$("#newprd-mask-bg");
	this.maskImg=$("#newprd-mask-img");
	this.config=$.extend({},slideProduct.defaultConfig,b);
	this._init()
}
slideProduct.prototype={

	_init:function(){
		this.mask.animate({opacity:1},this.config.duration);
		this._bindEvent()
	},startSlide:function(a,b){
		b=$(b).find("img")[a];
		this._cancelMove();
		this._slideMove(a,b)
	},_bindEvent:function(){
		var a=this;
		a.container.bind("mouseover",function(b){
			a._slideShow.call(a,b)
		})
	},_slideShow:function(a){
		a=a.target;
		var b;
		b=$(a).parents("ul").find("img").index(a);
		b>-1?this._slideMove(b,a):this._cancelMove()
	},_slideMove:function(a,b){
		function c(){
			var f=d.index;
			f=$(b).parents("ul").find("img")[f];
			var g=d.config.position[d.index];
			d.mask.css("opacity",0).css("left",g);
			d.reset();
			e(f,d);
			d._loadImg(f)
		}
		function e(f,g){
			f=f.parentNode;
			var h=f.title;
			g.link.attr("href",f.href).attr("title",h)
		}
		var d=this;
		d.index=a;
		if(!d.timer)
			d.timer=setTimeout(function(){
				c()
			},100)
	},_cancelMove:function(){
		if(this.timer){
			clearTimeout(this.timer);
			this.timer=undefined
		}
	},_loadImg:function(a){
		var b=a.getAttribute("data-large");
		this.maskBg.attr("src",a.src);
		this.maskImg.attr("src",b);
		this.mask.stop().animate({opacity:1},this.config.duration)
	},caculatePos:function(){
		for(var a=parseInt(this.mask.css("left")),b=this.config.position,c=0;c<5;c++)
			if(a===b[c])return c;
			return 3
		},reset:function(){
			this.maskBg.attr("src","images/ph.png");
			this.maskImg.attr("src","images/ph.png")
		}
	};
	
slideProduct.defaultConfig={
	position:[25,212,399,586,773],
	duration:150
};