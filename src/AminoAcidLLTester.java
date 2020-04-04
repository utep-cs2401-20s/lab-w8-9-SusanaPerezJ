import org.junit.jupiter.api.Test;

import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class AminoAcidLLTester {
    public String a = "CCGUUGGCACUGUUG";
    public String b = "UAUAGCGUGUUUUAUUGAUCUUGC";
    public String c = "GCUGAGGAUAUGUCA";
    public String d = "UGUUUUAAAAAUAACACU";
    public static void main(String[] args) {
        String a = "CCGUUGGCACUGUUGUAA";
        AminoAcidLL list = new AminoAcidLL();
        list.createFromRNASequence(a);
    }
    //createFromRNASequence test cases

    /*TEST 1
    *INPUT: "CCGUUGGCACUGUUG"
    * EXPECTED OUTPUT = P,L,A
    * ACTUAL OUTPUT = P,L,A
    *
    * With a string that has repeated codons, this also checks that the addCodon method and increaseCount method work properly.*/
    @Test
    public void rnatest1(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(a);
        char[] firstArr = new char[3];
        char[] answer = {'P','L','A'};
        for(int i = 0; i < firstArr.length; i++){
            firstArr[i] = first.aminoAcid;
            System.out.println(first.aminoAcid);
            first = first.next;
        }
        assertArrayEquals(answer, firstArr);
    }
    /*TEST 2
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void rnatest2(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(b);
        char[] firstArr = new char[4];
        char[] answer = {'T','S', 'V', 'F'};
        for(int i = 0; i < firstArr.length; i++){
            firstArr[i] = first.aminoAcid;
            System.out.println(first.aminoAcid);
            first = first.next;
        }
        assertArrayEquals(answer,firstArr);
    }
    /*TEST 3
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoListTest1(){

    }
    /*TEST 4
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoListTest2(){

    }
    /*TEST 5
     *INPUT:
     * EXPECTED OUTPUT = 1,3,1
     * ACTUAL OUTPUT = 1,3,1
     *
     * .*/
    @Test
    public void aminoCountsTest1(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(a);
        first.aminoAcidCounts();
        int[] firstArr = first.aminoAcidCounts();
        int[] expected = {1,3,1};
        assertArrayEquals(expected, firstArr);
    }
    /*TEST 6
     *INPUT:
     * EXPECTED OUTPUT = 2,1,1,1
     * ACTUAL OUTPUT = 2,1,1,1
     *
     * */
    @Test
    public void aminoCountsTest2(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(b);
        first.aminoAcidCounts();
        int[] firstArr = first.aminoAcidCounts();
        int[] expected = {2,1,1,1};
        assertArrayEquals(expected, firstArr);
    }
    /*TEST 7
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void sort1(){

    }
    /*TEST 8
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void sort2(){

    }
    /*TEST 9
     *INPUT:
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoCompareTest1(){
        //these list are already sorted
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(c);
        AminoAcidLL second = AminoAcidLL.createFromRNASequence(d);
        int expected = 1;
        assertEquals(expected, first.aminoAcidCompare(second));
    }
    /*TEST 10
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoCompareTest2(){
        //these list are already sorted
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(c);
        AminoAcidLL second = AminoAcidLL.createFromRNASequence(c);
        int expected = 0;
        assertEquals(expected, first.aminoAcidCompare(second));
    }
    /*TEST 11
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void codonCompare1(){

    }
    /*TEST 12
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void codonCompare2(){

    }

}