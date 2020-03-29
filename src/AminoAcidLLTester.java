import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AminoAcidLLTester {
    public static void main(String[] args) {
        AminoAcidLL list = new AminoAcidLL();
    }
    public String a = "CCGUUGGCACUGUUG";
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