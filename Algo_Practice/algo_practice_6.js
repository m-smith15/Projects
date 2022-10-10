/*
https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
*/

longestCommonPrefix = (strs) => {
    let results = ""
    let temp = "";
    let count = false;
    
    for (let x = 0; x < strs.length; x++) {
        
        temp = ""
        for (let y = 0; y < strs[x].length; y++) {
            // console.log(y)
            if (strs[x].split('')[y] == strs[0].split('')[y]) {
                // console.log(strs[x].split('')[y] + " matched " + temp[y])
                temp += strs[x].split('')[y]
            } else{
                break;
            }
        }
        // console.log(temp)
        if(x == 0 || temp.length < results.length){
            results = temp;
        }
    }

    return results
}



let strs = ["flower", "flow", "flight"]
// Output: "fl"
console.log(longestCommonPrefix(strs))

strs = ["dog","racecar","car"]
console.log(longestCommonPrefix(strs))
//Output: ""

strs = ["aaa","aa","aaa"]
console.log(longestCommonPrefix(strs))
// output - aa