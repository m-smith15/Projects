// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

// Input: head = [1,2,3,4,5]
// Output: [3,4,5]

// SLL is the array, can get length - 1 (index!)
// round length, pop items before "middle"
// potential edge cases - empty, length 1, length odd, length even

//its a singly linked list not an arry



function middleNode(head){
    results = [];
    let length = 0;
    while(this.next){
        length++;
    }
    let dest = 0;

    if(length <= 1){
        // console.log("0 or 1")
        return head;
    }
    else if(head.length % 2 > 0){ //handling Odd
        // console.log("odd")
        dest = (head[Math.floor(head.length/2)-1])
    }else{
        // console.log("else") / even
        dest = (head[Math.ceil(head.length/2)-1])
    }

    let runner = 0;
    while(runner < dest){
        this.head = this.next;
        runner++;
    }

    return this.head;

}

head1 = [1,2,3,4,5]
console.log(middleNode(head1))

head2 = [1,2,3,4,5,6]
console.log(middleNode(head2))

// console.log(head2.splice(head2[Math.ceil(head2.length/2)-1]))


// console.log(head2.length % 2)
// console.log(Math.ceil(head2.length/2) )
// console.log(head2[Math.ceil(head2.length/2) - 1])
// console.log(head2.splice(head2[Math.floor(head2.length/2)-1]))
// expect [3,4,5] as return