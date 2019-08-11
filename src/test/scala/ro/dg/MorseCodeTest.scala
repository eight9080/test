package ro.dg

import com.example.alg.stringpck.MorseCode
import org.junit.Assert.assertEquals
import org.junit.Test

class MorseCodeTest {

  @Test def uniqueMorseRepresentations(): Unit = {
    val morseCode = new MorseCode
    val uniqueMorseRepresentations =
      morseCode.uniqueMorseRepresentations(Array[String]("gin", "zen", "gig", "msg"))
    assertEquals(2, uniqueMorseRepresentations)
  }

}
