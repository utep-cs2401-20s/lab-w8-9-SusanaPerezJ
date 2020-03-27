import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AminoAcidLLTester {
    public String a = "CCGUUGGCACUGUUG";
    @Test
    public void rnatest(){
        AminoAcidLL first = new AminoAcidLL();
        first.createFromRNASequence(a);
    }

}