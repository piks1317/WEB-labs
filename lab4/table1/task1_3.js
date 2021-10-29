const prompt = require('prompt-sync')();

var length = prompt("Write size of array : ");

var array_a = [];

for (i = 0; i < length; i++) {
    array_a.push(Math.round(Math.random() * 100));
}

var max = 0;

for (i = 0; i < array_a.length; i++) {
    if (array_a[i] > max) {
        max = array_a[i];
    }
}

function printArray(array) {
    var log = [];

    for (i = 0; i < array.length; i++) {
        if (i < array.length - 1) {
            log += array[i] + ', ';
        } else { log += array[i] }

    }
    console.log(log);
}

printArray(array_a);

console.log("Max element : " + max);


var array_b = [];

for (i = 0; i < length; i++) {
    array_b.push(array_a[i] * max);
}

printArray(array_b);