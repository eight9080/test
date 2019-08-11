package ro.dg

import java.util

object MorseCode {
  def uniqueMorseRepresentations(words: Array[String]): Int = {


    val morseDictionary : Array[String] = Array[String](".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
      "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
      "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")

    val morseRepresentations: util.Set[String] = new util.HashSet[String]

    for (word: String <- words){
      val morseResult = new StringBuilder

      for (character: Char <- word.toCharArray){
        morseResult.append(morseDictionary(character - 'a'))
      }
      morseRepresentations.add(morseResult.toString)
    }

    morseRepresentations.size()
  }
}
