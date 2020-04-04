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
                 /////*createFromRNASequence test cases*////

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
                        /////*aminoAcidList test cases*/////
    /*TEST 3
     *INPUT: "CCGUUGGCACUGUUG"
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * This test ensures that the method returns an array with the aminoacids of the linked list in the order they appear.*/
    @Test
    public void aminoListTest1(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(a);
        char[] expected = {'P','L','A'};
        assertArrayEquals(expected, first.aminoAcidList());
    }
    /*TEST 4
     *INPUT: "UGUUUUAAAAAUAACACU";
     * EXPECTED OUTPUT = T, S, V, F
     * ACTUAL OUTPUT = T, S, V, F
     *
     * The tests creates an AminoAcidLL with a string that has a STOP codon to ensure that the stop works and only the wanted codons are converted to aminoacids and then added to the array*/
    @Test
    public void aminoListTest2(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(d);
        char[] expected = {'C','F','K','N','T'};
        assertArrayEquals(expected, first.aminoAcidList());
    }
                        /////*aminoAcidCounts test cases*/////
    /*TEST 5
     *INPUT: "CCGUUGGCACUGUUG"
     * EXPECTED OUTPUT = 1,3,1
     * ACTUAL OUTPUT = 1,3,1
     *
     * This test uses the aminoAcidCounts method on every node of the list and then, adds its result to an array.*/
    @Test
    public void aminoCountsTest1(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(a);
        int[] expected = {1,3,1};
        assertArrayEquals(expected, first.aminoAcidCounts());
    }
    /*TEST 6
     *INPUT: "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = 2,1,1,1
     * ACTUAL OUTPUT = 2,1,1,1
     *
     * This test uses the aminoAcidCounts method on every node of the list and then, adds its result to an array*/
    @Test
    public void aminoCountsTest2(){
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(b);
        int[] expected = {2,1,1,1};
        assertArrayEquals(expected, first.aminoAcidCounts());
    }
                        /////*aminoAcidCompare test cases*/////
    /*TEST 7
     *INPUT:  c = "GCUGAGGAUAUGUCA", d = "UGUUUUAAAAAUAACACU"
     * EXPECTED OUTPUT = 1
     * ACTUAL OUTPUT = 1
     *
     *  Using two lists of different "size", the number of nodes it's compared to check that their difference is 1.*/
    @Test
    public void aminoCompareTest1(){
        //these list are already sorted
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(c);
        AminoAcidLL second = AminoAcidLL.createFromRNASequence(d);
        int expected = 1;
        assertEquals(expected, first.aminoAcidCompare(second));
    }
    /*TEST 8
     *INPUT: c = "GCUGAGGAUAUGUCA"
     * EXPECTED OUTPUT = 0
     * ACTUAL OUTPUT = 0
     *
     * Using two lists of the same "size", the number of nodes it's compared to check that they are the same.*/
    @Test
    public void aminoCompareTest2() {
        //these list are already sorted
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(c);
        AminoAcidLL second = AminoAcidLL.createFromRNASequence(c);
        int expected = 0;
        assertEquals(expected, first.aminoAcidCompare(second));
    }
                        /////*codonCompare test cases*/////
    /*TEST 9 - failed
     *INPUT: a = "CCGUUGGCACUGUUG", b = "UAUAGCGUGUUUUAUUGAUCUUGC"
     * EXPECTED OUTPUT = 0
     * ACTUAL OUTPUT = 2
     *
     * This test checks the difference between the count of codons of two lists. This test failed, the expected output is 0 but the method returned 2.*/
    @Test
    public void codonCompare1(){
        //these list are already sorted
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(a);
        AminoAcidLL second = AminoAcidLL.createFromRNASequence(b);
        int expected = 0;
        assertEquals(expected, first.codonCompare(second));
    }
    /*TEST 10
     *INPUT: c = "GCUGAGGAUAUGUCA", d = "UGUUUUAAAAAUAACACU";
     * EXPECTED OUTPUT = 1
     * ACTUAL OUTPUT = 1
     *
     * This test checks the difference between the count of codons of two lists.*/
    @Test
    public void codonCompare2(){
        //these list are already sorted
        AminoAcidLL first = AminoAcidLL.createFromRNASequence(c);
        AminoAcidLL second = AminoAcidLL.createFromRNASequence(d);
        int expected = 1;
        assertEquals(expected, first.codonCompare(second));

    }

}