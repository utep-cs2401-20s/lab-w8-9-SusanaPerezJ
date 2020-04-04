import org.junit.jupiter.api.Test;

import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class AminoAcidLLTester {
    public String a = "CCGUUGGCACUGUUG";
    public String b = "UAUAGCGUGUUUUAUUGAUCUUGC";
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
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoCountsTest1(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(a);
        int[] expected = first.aminoAcidCounts();

    }
    /*TEST 6
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoCountsTest2(){

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
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoCompareTest(){

    }
    /*TEST 10
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * With a string that has a STOP codon to check the condition on createFromRNASequence that stops the creation of codons even if there are more codons in front of the stop.*/
    @Test
    public void aminoCompare2(){

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