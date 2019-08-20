package com.example.quinielaapp.network

class RetrofitClient {

    object GFG {

        var numberOfCodes = 1
        var arrayOfCodes= mutableListOf<String>()

        @JvmStatic
        fun main(args: Array<String>) {
            val inputCode = "qqqw"

            getNumberOfCombinations(inputCode)
            getArrayOfCombinations(inputCode, "")
            sortCodes()
            deleteRepeatedElements()
            printAllCodes()
            printNumberOfCombinations()
            printNextCode(arrayOfCodes,inputCode)
        }

        fun getNumberOfCombinations(inputCode: String){
            for (i in 0 until inputCode.length){
                numberOfCodes *= (i + 1)
            }
        }

        fun getArrayOfCombinations(inputCode: String, ans: String){
            if (inputCode.isEmpty()){
                arrayOfCodes.add(ans)
                print("$ans\n")
            }
            else{
                for(i in 0 until inputCode.length){
                    val character = inputCode[i]
                    val substring1 = inputCode.substring(0, i)
                    val substring2 = inputCode.substring(i + 1)
                    val restOfInputCode =  substring1 + substring2

                    getArrayOfCombinations(restOfInputCode, ans + character)
                }
            }
        }

        fun sortCodes(){
            val sortedCodes = arrayOfCodes.sortedBy { it }
            arrayOfCodes = sortedCodes as MutableList<String>
        }

        fun deleteRepeatedElements(){
            val cleanedArray = arrayOfCodes.distinct()
            arrayOfCodes = cleanedArray as MutableList<String>
        }

        fun printAllCodes(){
            for (code in arrayOfCodes){
                print("$code \n")
            }
        }

        fun printNumberOfCombinations(){
            print("El número de combinaciones es $numberOfCodes \n")
        }

        fun printNextCode(codesArray: List<String>, inputCode: String){
            for (i in 0 until codesArray.size){
                if (inputCode.equals(codesArray[i])){
                    if (i+1 != codesArray.size){
                        print("El siguiente código es ${codesArray[i+1]}")
                    }
                    else{
                        print("No sucesor")
                    }
                }
            }
        }
    }
}