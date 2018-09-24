package com.hyeran.android.dodobo.recommend

/*
코틀린

변수
var/val 변수명 : 변수형

함수
fun 함수명(인자명 : 인자형) : 리턴형

생성자는 매개변수 받아서 클래스 스코프 내에서 선언, 초기화
 */

class CourseSpinner(icon : Int) {
    var _icon : Int = icon

    fun getIcon() : Int {
        return _icon
    }

    fun setIcon() {
        this._icon = _icon
    }
}