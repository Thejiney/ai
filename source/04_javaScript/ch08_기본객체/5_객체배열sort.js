function Studnet(name, kor, mat) {
    this.name = name;
    this.kor = kor;
    this.mat = mat;
}

Studnet.prototype.getSum = function () {
    return this.kor + this.mat;
};

Studnet.prototype.toString = function () {
    return (
        this.name + "(" + this.kor + "," + this.mat + "," + this.getSum() + ")"
    );
};
var students = [
    new Studnet("홍", 70, 90),
    new Studnet("박", 99, 99),
    new Studnet("김", 56, 61),
    new Studnet("윤", 99, 97),
];
var studentsCopy = [...students]; // 깊은 복사
studentsCopy.sort(function (left, right) {
    return right.getSum() - left.getSum(); // 총점기준으로 내림차순 정렬
});
console.log("원본");
students.forEach((data, idx) => {
    console.log(idx + "," + data.toString());
});
console.log("정렬된 복사본");
studentsCopy.forEach((data, idx) => {
    console.log(idx + "," + data.toString());
});
