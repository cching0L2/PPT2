package permutationcipher;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PermutationCipher {

	/**
	 * Encrypts a string by generating a permutation of the characters in the
	 * string. The permutation is specified by permutationArray and the
	 * characters may be permuted more than once depending on the number of
	 * rounds indicated.
	 * 
	 * @param plaintext
	 *            the text to encrypt.
	 * @param permutationArray
	 *            the array the specifies how to permute the plain text. A
	 *            suitable permutation array must be equal in length to the
	 *            plain text and must be a permutation of integers in [0 ..
	 *            permutationArray.length-1].
	 * @param rounds
	 *            the number of rounds of encryption needed; rounds should be at
	 *            least 1.
	 * @return the encrypted text (ciphertext).
	 * @throws IllegalKeyException
	 *             if the permutation array is not suitable.
	 */
    
	public static String encrypt(String plaintext, int[] permutationArray, int rounds) throws IllegalKeyException {
		StringBuilder ciphertextBuilder = new StringBuilder();
		List<Integer> permArray = new LinkedList<Integer>();
		Map<Integer, Character> charDest = new HashMap<Integer, Character>();
		Integer destIndex;
		Integer plainTextIndex;
		
		String currplaintext="";
		
		String encrypted="";
		
		currplaintext = plaintext;
    
            for(int i=0; i<permutationArray.length; i++){
                permArray.add(permutationArray[i]);
            }
            
            for(Integer content: permArray){
                if(content<0 | content>(permArray.size()))
                    throw new IllegalKeyException();
            }
            
            for(int index=0; index<permArray.size(); index++){
                if(!permArray.contains(index))
                    throw new IllegalKeyException();
            }
            
    		for(int rep = 0; rep<rounds; rep++){
    		    if(rep>0)
    		        currplaintext = encrypted;
        		
        		for(int i : permArray){
        		    destIndex = i;
        		    plainTextIndex = permArray.indexOf(i);
        		    charDest.put(destIndex, currplaintext.charAt(plainTextIndex.intValue()));
        		}
                
                //start appending things
                for(int i=0; i<plaintext.length();i++){
                    ciphertextBuilder.append(charDest.get(i));
                }
                
                encrypted = ciphertextBuilder.toString();
                
                ciphertextBuilder.replace(0, encrypted.length(), ""); //reset ciphertextBuilder
                charDest.clear();
    		}

        System.out.println("encrypted (returned string) is: "+encrypted);
		return encrypted;
	}

}

class IllegalKeyException extends Exception{
    public IllegalKeyException(){
        System.out.println("Permutation array is not suitable.");
    }
}
