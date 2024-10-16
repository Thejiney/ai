function sumAll() {
    let result = -999;
    if (arguments.length >= 1) {
        result = 0;
        for (let idx = 0; idx < arguments.length; idx++) {
            result += arguments[idx];
        }
    }
    return result;
}
