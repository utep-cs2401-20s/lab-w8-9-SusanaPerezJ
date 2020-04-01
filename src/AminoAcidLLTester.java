import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AminoAcidLLTester {
    public String a = "CCGUUGGCACUGUUG";
    public static void main(String[] args) {
        String a = "CCGUUGGCACUGUUGUAA";
        AminoAcidLL list = new AminoAcidLL();
        list.createFromRNASequence(a);
    }
    @Test
    public void rnatest(){
        AminoAcidLL first = new AminoAcidLL();
        first.createFromRNASequence(a);
    }
    @Test
    public void rnatest1(){
        AminoAcidLL first = new AminoAcidLL();
        first.createFromRNASequence(a);
    }
}