//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface
import java.lang.reflect.Array;
import java.util.ArrayList;
public class TrieMap implements TrieMapInterface{
  private TrieMapNode root;
  
  public TrieMap(){
    root = new TrieMapNode();
  }
  
  //Indirectly recursive method to meet definition of interface
  public void put(String key, String value){
    put(root, key, value);
  }

  //Recursive method
  private void put(TrieMapNode current, String curKey, String value){
    if(current.getChildren().isEmpty() || !current.getChildren().containsKey(curKey.charAt(0))) {
      // add children
      current.getChildren().put(curKey.charAt(0), new TrieMapNode());

    }
    if(curKey.length() == 1) {

      current.getChildren().get(curKey.charAt(0)).setValue(value);
    }
    else {
      put(current.getChildren().get(curKey.charAt(0)), curKey.substring(1), value);
    }
    if (current.getChildren().containsKey(curKey.charAt(0))){

      if(curKey.length()>1)
        put(current.getChildren().get(curKey.charAt(0)), curKey.substring(1), value);
    }
  }
  
  //Indirectly recursive method to meet definition of interface
  public String get(String key){
    return get(root, key);
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  private String get(TrieMapNode current, String curKey){
    TrieMapNode temp = findNode(current, curKey);
    if(temp != null){
      return temp.getValue();
    }
    else{
      return null;
    }
  }
  
  //Indirectly recursive method to meet definition of interface
  public boolean containsKey(String key){
    return containsKey(root, key);
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  private boolean containsKey(TrieMapNode current, String curKey){
    return get(current, curKey) != null;
  }
  
  //Indirectly recursive method to meet definition of interface
  public ArrayList<String> getKeysForPrefix(String prefix){
    TrieMapNode temp = findNode(root, prefix);
    if(temp != null)
    return getSubtreeKeys(temp);
    else return new ArrayList<>();
  }
  
  //Recursive helper function to find node that matches a prefix
  //Note: only a suggestion, you may solve the problem is any recursive manner
  private TrieMapNode findNode(TrieMapNode current, String curKey){
    if(curKey.length() == 0){
      return current;
    }
     if(current.getChildren().containsKey(curKey.charAt(0))){
      return findNode(current.getChildren().get(curKey.charAt(0)), curKey.substring(1));
    }
    return null;
  }
  
  //Recursive helper function to get all keys in a node's subtree
  //Note: only a suggestion, you may solve the problem is any recursive manner
  public ArrayList<String> getSubtreeKeys(TrieMapNode current){
    ArrayList<String> temp = new ArrayList<>();
    if (current.getValue() != null) {
        temp.add(current.getValue());
      }

    if(!current.getChildren().isEmpty()){
      for(Character c: current.getChildren().keySet()){
        temp.addAll(getSubtreeKeys(current.getChildren().get(c)));

      }
    }
    return temp;

  }
  
  //Indirectly recursive method to meet definition of interface
  public void print(){
    print(root);
  }
  
  //Recursive method to print values in tree
  private void print(TrieMapNode current) {
    ArrayList<String> temp = getSubtreeKeys(current);
    int c = 0;
    for(String s: temp){
      System.out.println(s);
      c++;
    }
   System.out.println("Total words printed: " + c);
    }

  public static void main(String[] args){
    //You can add some code in here to test out your TrieMap initially
    //The TrieMapTester includes a more detailed test
  }
}