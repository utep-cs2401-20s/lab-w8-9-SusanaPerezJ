import javax.swing.text.html.InlineView;

class AminoAcidLL{
  char aminoAcid;
  String[] codons;
  int[] counts;
  AminoAcidLL next;



  public static AminoAcidLL head;
  public static AminoAcidLL iterator = head;
  public static int size = 0;
  public static char[] aminoacids;
  public static boolean populate;
  public static int i = 0;
  public static AminoAcidLL temp = iterator;

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
  public int aminoAcidCompare(AminoAcidLL inList){
    if(inList == null){
      int a = this.totalCount();
    }
    if(this == null && inList != null){
      //recursive call through inList

    }
    return 0;
  }

  /********************************************************************************************/
  /* Same ad above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList){
    //difference in number of counts
    return 0;
  }


  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  public char[] aminoAcidList(){
    //set the iterator equal to the head of the list
    if(iterator == null){
      iterator = head;
    }
    //the populate boolean is only true if the length of the array is known
    if(populate){
      //return the array when it is populated
      if(i >= aminoacids.length) {
        return aminoacids;
      }
      //populate the array
      aminoacids[i] = iterator.aminoAcid;
      iterator = iterator.next;
      System.out.println(aminoacids[i]);
      //increase the count (index)
      i++;
      //recursive call
      aminoAcidList();
    }else{
      //when the iterator gets to the last node, the array is initialized with the appropriate size.
      if(iterator.next == null){
        aminoacids = new char[size + 1];
        System.out.println(aminoacids.length);
        populate = true;
        iterator = head;
      }else {
        //while the iterator traverses the list, the size increases
        size++;
        iterator = iterator.next;
        System.out.println(iterator.aminoAcid);
      }
      return aminoAcidList();
    }
    return null;
  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    //recursive

    return new int[]{};
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
    //don't forget to check for errors
    AminoAcidLL list = new AminoAcidLL(inSequence.substring(0,3));
    while(inSequence.length() != 0) {
      if(list.next == null){
        head = list;
        //System.out.println("head is:" + head.aminoAcid);
      }
      String newStr = inSequence.substring(0,3);
      list.addCodon(newStr);
      inSequence = inSequence.substring(3);
    }
    sort(list);
    return list;
  }
//helper method to print the list
  public static void printList(AminoAcidLL list){
    int count = 1;
    AminoAcidLL iterator = list;
    while (iterator != null) {
      System.out.println("Codon " + count + ": " + iterator.aminoAcid);
      countsFromCodon(iterator);
      iterator = iterator.next;
      count++;
    }
  }
  public static void countsFromCodon(AminoAcidLL codon){
    for(int i = 0; i < codon.counts.length; i++){
      System.out.print(codon.counts[i] + ", ");
    }
    System.out.println();
  }

  /********************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList) {
    if(iterator.next == null){
      return inList;
    }

    return inList;
  }
}