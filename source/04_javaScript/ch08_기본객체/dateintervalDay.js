// now.getIntervalDay(limitDay) => 100 return
Date.prototype.getIntervalDay = function (otherDay) {
    //now.getIntervalDay(limitDay) => now가 this, limitDay가 otherDay
    // if (otherDay > this) {
    //     var intervalMilliSec = otherDay.getTime() - this.getTime();
    // } else {
    //     var intervalMilliSec = this.getTime() - otherDay.getTime();
    // }
    let day = Math.trunc(
        Math.abs(this.getTime() - otherDay.getTime()) / (1000 * 60 * 60 * 24)
    );
    return day;
};

// var today = new Date();
// var thatDay = new Date(2024, 9, 11, 14, 0, 0);
// console.log(today.getIntervalDay(thatDay));
// console.log(thatDay.getIntervalDay(today));
