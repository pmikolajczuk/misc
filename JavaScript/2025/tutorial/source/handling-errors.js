// let a = 7 * undefined / "panama";
// console.log(a); // NaN

/* function beforeTryCatch() {
    let obj = undefined;
    console.log(obj.b);
    console.log("This line will not be executed.");
} */


//beforeTryCatch();

/* function afterTryCatch() {
    try {
        let obj = undefined;
        console.log(obj.b);
        console.log("This line will not be executed.");
    } catch (error) {
        console.log("An error occurred:", error.message);
    } finally {
        console.log("This block always executes.");
    }

    console.log("Execution continues after the try-catch block.");
}

afterTryCatch(); */

function performCalculation(obj) {
    if (!obj.hasOwnProperty('b')) {
        throw new Error("Property 'b' is missing from the object.");
    }
    // Proceed with calculation
    return obj.b * 2;
}

function performHigherLevelCalculation() {
    let obj = {}; // 'b' is missing
    let value = 0;
    try {
        value = performCalculation(obj);
    } catch (error) {
        console.log(error.message);
    }

    if (value == 0) {
        // Fallback calculation...
    }
}

performHigherLevelCalculation();