function count() {
    var data = new Date();
    now = data.getTime();
    var str = "2018/01/18 10:30:00";
    var endDate = new Date(str);
    var end = endDate.getTime();

    var leftTime = end - now;
    var d, h, m, s;
    if (leftTime >= 0) {
        d = Math.floor(leftTime / 1000 / 60 / 60 / 24);
        h = Math.floor(leftTime / 1000 / 60 / 60 % 24);
        m = Math.floor(leftTime / 1000 / 60 % 60);
        s = Math.floor(leftTime / 1000 % 60);
    }

    document.getElementById("_d").innerHTML = d + "天";
    document.getElementById("_h").innerHTML = h + "时";
    document.getElementById("_m").innerHTML = m + "分";
    document.getElementById("_s").innerHTML = s + "秒";

    document.getElementById("_d1").innerHTML = d + "天";
    document.getElementById("_h1").innerHTML = h + "时";
    document.getElementById("_m1").innerHTML = m + "分";
    document.getElementById("_s1").innerHTML = s + "秒";

    document.getElementById("_d2").innerHTML = d + "天";
    document.getElementById("_h2").innerHTML = h + "时";
    document.getElementById("_m2").innerHTML = m + "分";
    document.getElementById("_s2").innerHTML = s + "秒";


}

setInterval(count, 0);
