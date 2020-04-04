import javax.swing.text.html.InlineView;

class AminoAcidLL{
  char aminoAcid;
  String[] codons;
  int[] counts;
  AminoAcidLL next;

  public static AminoAcidLL iterator;
  AminoAcidLL(){
  }


  /********************************************************************************************/
  /* Creates a new node, with a given amino acid/codon 
   * pair and increments the codon counter for that codon.
   * NOTE: Does not check for repeats!! */
  AminoAcidLL(String inCodon){
    aminoAcid = AminoAcidResources.getAminoAcidFromCodon(inCodon);
    codons = AminoAcidResources.getCodonListForAminoAcid(aminoAcid);
    counts = new int[codons.length]; //increment at the index where the codon that repeats is
    next = null;
  }

  /********************************************************************************************/
  /* Recursive method that increments the count for a specific codon:
   * If it should be at this node, increments it and stops, 
   * if not passes the task to the next node. 
   * If there is no next node, add a new node to the list that would contain the codon. 
   */

  //I got help from Michelle for this method//
  private void addCodon(String inCodon){
    //base case
    if(aminoAcid == AminoAcidResources.getAminoAcidFromCodon(inCodon)){
      incrementCounts(inCodon);
    }else if(next != null){
        next.addCodon(inCodon);
    }else{
      AminoAcidLL aminoacid = new AminoAcidLL(inCodon);
      next = aminoacid;
      addCodon(inCodon);
      }
    }

  //increases count on a node
  private void incrementCounts(String inCodon){
    //System.out.println("array of " + aminoAcid + ": ");
    for(int i = 0; i < codons.length; i++){
      if(inCodon.equalsIgnoreCase(codons[i])){
        counts[i]++;
      }
      //System.out.print(counts[i] + ", ");
    }
    //System.out.println();
  }


  /********************************************************************************************/
  /* Shortcut to find the total number of instances of this amino acid */
  private int totalCount(){
    //sum elements in counts[]
    int sum = 0;
    for(int i = 0; i < counts.length; i++){
      sum += counts[i];
    }
    return sum;
  }

  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int totalDiff(AminoAcidLL inList){
    return Math.abs(totalCount() - inList.totalCount());
  }


  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int codonDiff(AminoAcidLL inList){
    int diff = 0;
    for(int i=0; i<codons.length; i++){
      diff += Math.abs(counts[i] - inList.counts[i]);
    }
    return diff;
  }

  /********************************************************************************************/
  /* Recursive method that finds the differences in **Amino Acid** counts. 
   * the list *must* be sorted to use this method */

  //I got help from Cynthia for this method//
  public int aminoAcidCompare(AminoAcidLL inList){
    // Checking if the list is sorted
    if(!inList.isSorted()) {
      return -1;
    }
    int diff = 0;
    if(inList == null) {
      diff += totalCount();
    }
    if(next != null) {
      diff += next.aminoAcidCompare(inList.next);
    }else if(aminoAcid == inList.aminoAcid) {
      diff += totalDiff(inList);
      if(next != null) {
        diff += next.aminoAcidCompare(inList.next);
      }
      if(next == null && inList.next != null) {
        diff += aminoAcidCompare(inList.next);
      }
    }else if(next == null || aminoAcid > inList.aminoAcid){
      diff += inList.totalCount();
      if(inList.next != null) {
        diff += aminoAcidCompare(inList.next);
      }
    }else if(inList.aminoAcid > aminoAcid && next != null) {
      diff += totalCount();
      if(next != null) {
        diff += next.aminoAcidCompare(inList);
      }
    }
    return diff;
  }

  /********************************************************************************************/
  /* Same ad above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList){
    if(!inList.isSorted()) {
      return -1;
    }
    int diff = 0;
    if(inList == null) {
      diff += totalCount();
    }
    if(next != null) {
      diff += next.codonCompare(inList.next);
    }else if(aminoAcid == inList.aminoAcid) {
      diff += codonDiff(inList);
      if(next != null) {
        diff += next.codonCompare(inList.next);
      }
      if(next == null && inList.next != null) {
        diff += codonCompare(inList.next);
      }
    } else if(next == null || aminoAcid > inList.aminoAcid) {
      diff += inList.totalCount();
      if(inList.next != null) {
        diff += codonCompare(inList.next);
      }
    }else if(next != null && aminoAcid < inList.aminoAcid) {
      diff+= totalCount();
      if(next != null) {
        diff += next.codonCompare(inList);
      }
    }
    return diff;
  }


  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  public char[] aminoAcidList(){
    if(next == null){
      return new char[]{aminoAcid};
    }
    char[] amino = next.aminoAcidList();
    char[] aminoList = new char[amino.length+1];

    aminoList[0] = aminoAcid;
    //loop to populate
    for(int i = 1; i < aminoList.length; i++){
      aminoList[i] = amino[i-1];
    }
   return aminoList;
  }


  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    //recursive
    if(next == null){
      return new int[]{totalCount()};
    }
    int[] amino = next.aminoAcidCounts();

    int[] ret = new int[amino.length+1];
    ret[0] = totalCount();
    //loop to populate
    for(int i = 1; i < ret.length; i++){
      ret[i] = amino[i-1];
    }
    return ret;
  }


  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted(){
    if(iterator.aminoAcid > iterator.next.aminoAcid){
      return false;
    }else{
      iterator = iterator.next;
      isSorted();
    }
    return true;
  }


  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  public static AminoAcidLL createFromRNASequence(String inSequence){
    AminoAcidLL list = new AminoAcidLL(inSequence.substring(0,3));
    while(inSequence.length() != 0) {
      String newStr = inSequence.substring(0,3);
      if(AminoAcidResources.getAminoAcidFromCodon(newStr) != '*'){
        list.addCodon(newStr);
        inSequence = inSequence.substring(3);
      }else{
        inSequence = "";
      }
    }
    sort(list);
    printList(list);
    return list;
  }

//helper method to print the list
  public static void printList(AminoAcidLL list){
    int count = 1;
    //AminoAcidLL iterator = list;
    while (list != null) {
      System.out.println("Codon " + count + ": " + list.aminoAcid);
      //countsFromCodon(iterator);
      System.out.println(list.totalCount());
      list = list.next;
      count++;
    }
  }
  //helper method to check the content of counts
  public static void countsFromCodon(AminoAcidLL codon){
    for(int i = 0; i < codon.counts.length; i++){
      System.out.print(codon.counts[i] + ", ");
    }
    System.out.println();
  }

  /********************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList) {
    AminoAcidLL head = inList;
    AminoAcidLL iterator = null;
    AminoAcidLL temp;

  //return list if its null or if it only has one node
    if(head == null || inList.next == null) {
      return inList;
    }else {
      while(head != null) {
        iterator = inList.next;
        while(iterator != null) {
          if(inList.aminoAcid > iterator.aminoAcid) {
            //swap pointers
            temp = iterator;
            head.next = iterator.next;
            temp.next = head;
          }
          iterator = iterator.next;
        }
        head = head.next;
      }
    }
    inList = head;
    return inList;
  }
}