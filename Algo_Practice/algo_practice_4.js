
//checking to see if SLL is palindrome
//needed a hand w/ this one my SLL skills need some work! Converting to array initially seems like...cheating? But its a neat workaround that seems to be rather efficient

//create a loop that pushes all the values in head to an array, have a start and end point and have them work towards the middle. If either are off then it returns false. Because its a SLL it can't be sorted, so we don't have to worry about shuffling for possiblities either


var isPalindrome = function(head) {
    let toArry = [];
    while(head){
        toArry.push(head.val)
        head = head.next;
    }
    console.log(toArry)

    let start = 0;
    let end = toArry.length - 1;
    console.log(end)
    while(start < end){
        if(toArry[start] == toArry[end]){
            start++;
            end--;
        }
        else{
            return false;
        }
    }
    return true;
};
let head = [1,2,2,1]
console.log(isPalindrome(head))