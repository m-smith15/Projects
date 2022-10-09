/* 
https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

twoSum = (nums, target) =>{

    let j = 0;
    let temp = 0;
    let results = []

    while(j < nums.length){

    for(let x = j + 1; x < nums.length; x++){


        if(nums[j] + nums[x] == target){
            results.push(j)
            results.push(x)
            return results
        }
    }
    j++;
}

}

// Input: 
let nums = [0,4,3,0], target = 0
// Output: [0,1]
console.log(twoSum(nums, target))