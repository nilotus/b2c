var b=new slideProduct(".tabslidepic");

new Slide(".tabslidepic",{
	switchTo:3,
	delay:0.25,
	duration:0.8,
	effect:"scrollx"
	},{onSwitch:function(a,c){
		b.caculatePos();
		b.startSlide(2,c.panels[a])
	},beforeSwitch:function(){
		b.mask.css({opacity:0});
		b.reset()
	}
});