package com.example.alarmmanager

data class AlarmDisplayModel(
    val hour: Int,
    val minute: Int,
    var onOff: Boolean
) {
    val timeText: String
        get() {
            val h =
                "%02d".format(if (hour < 12) hour else hour - 12) //%02d -> 2자리수 까지 인트형으로 들어올 수 있고 2자리수가 아니면 앞에 공백을 0으로 채움
            val m = "%02d".format(minute)
            return "$h:$m"
        }

    val ampmText: String
        get() {
            return if (hour < 12) "AM" else "PM"
        }

    val onOffText: String
        get() {
            return if(onOff) "Alarm Start" else "Alarm Stop"
        }

    fun makeDataForDB(): String {
        return "$hour:$minute"
    }
}