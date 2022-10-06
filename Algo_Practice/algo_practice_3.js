/* https://leetcode.com/problems/ransom-note/

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

*/ 


// not the greatest solution. I'd like to come back to this and try using reduce(). Got a bit of a bandaid on it right now when a match is found, and a double for loop doesn't doing big O any favors
canConstruct = (ransomNote, magazine) => {

    let ransom = ransomNote.split('')
    let mag = magazine.split('')

    let result = []

    for(let x = 0; x < ransom.length; x++){
        // console.log(x)
        // console.log("mag " + mag[x])
        for(let y = 0; y < mag.length; y++){
            // console.log(" ransom "  + ransom[y])
            if( mag[y] == ransom[x]){
                // console.log("match")
                mag[y] = ''
                result.push(ransom[x])
                break;
            }
        }
    }
    result = result.join('')
    console.log(result)

    if(result == ransomNote){
        return true;
    } else{
        return false;
    }

}

let ransomNote = "a", magazine = "b" //false
console.log(canConstruct(ransomNote, magazine))
let ransomNote2 = "aa", magazine2 = "ab" //false
console.log(canConstruct(ransomNote2, magazine2))
let ransomNote3 = "aa", magazine3 = "ab" //true
console.log(canConstruct(ransomNote3, magazine3))