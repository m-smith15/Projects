// https://leetcode.com/problems/roman-to-integer/

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
*/

romanToInt = (input) => {

    chars = input.split('')
    output = 0;

    for (let x = 0; x < chars.length; x++) {
        if (chars[x] == "I") {
            if (chars[x + 1] == "V") {
                output += 4
                x++;
            } else if (chars[x + 1] == "X") {
                output += 9
                x++;
            } else {
                output += 1
            }
        }
        else if (chars[x] == "V") {
            output += 5
        }
        else if (chars[x] == "X") {
            if (chars[x + 1] == "L") {
                output += 40
                x++;
            } else if (chars[x + 1] == "C") {
                output += 90
                x++;
            } else {
                output += 10
            }
        }
        else if (chars[x] == "L") {
            output += 50
        }
        else if (chars[x] == "C") {
            if (chars[x + 1] == "D") {
                output += 400
                x++;
            } else if (chars[x + 1] == "M") {
                output += 900
                x++;
            } else {
                output += 100
            }
        }
        else if (chars[x] == "D") {
            output += 500
        }
        else if (chars[x] == "M") {
            output += 1000
        }
        console.log(output)
    }

    return output
}

console.log(romanToInt("III"))
console.log(romanToInt("LVIII"))
console.log(romanToInt("MCMXCIV"))