/*
    Name: Ken Ogihara
    PID:  A16969236
 */

/**
 * Implementation of Protein Synthesis class.
 *
 * @author Ken Ogihara
 * @since ${2/7/24}
 */
class ProteinSynthesis {

    /* Magic numbers */
    public static final int GROUP = 3;
    public static final int CODON = 3;

    /**
     * Method that transcribes DNA to RNA by replacing Thymine nucleotides with Uracil.
     *
     * @param dna a string of characters.
     * @return transcription which is an object of the CharQueue class.
     * @throws IllegalArgumentException if the length of the string is not divisible by 3.
     **/
    public MyQueue<Character> transcribeDNA(String dna) {
        if (dna.length() % GROUP != 0) {
            throw new IllegalArgumentException("Not divisible by 3");
        }
        MyQueue<Character> transcription = new MyQueue<>();

        for (char nucleotide : dna.toCharArray()) {
            if (nucleotide == 'T') {
                transcription.enqueue('U');
            } else {
                transcription.enqueue(nucleotide);
            }
        }
        return transcription;
    }


    /**
     * Method that translates a given RNA to a protein.
     *
     * @param rna an object of MyQueue.
     * @return a queue that includes the RNA's corresponding amino acids.
     **/
    public MyQueue<Character> translateRNA(MyQueue<Character> rna) {
        MyQueue<Character> emptyQueue = new MyQueue<>();
        if (rna.isEmpty()) {
            return emptyQueue;
        }
        if (rna.peek() == 'A' && rna.myList.get(1) == 'U' && rna.myList.get(2) == 'G') {
            String codon = "";
            MyQueue<String> aminoAcidChain = new MyQueue<>(rna.size() / CODON);
            int groups = rna.size() / CODON;
            for (int i = 0; i < groups; i++) {
                codon += rna.dequeue() + "" + rna.dequeue() + "" + rna.dequeue();
                if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
                    return aminoAcidChain;
                } else {
                    aminoAcidChain.enqueue(CodonMap.getAminoAcid(codon));
                }
                codon = "";
            }
            return aminoAcidChain;

        } else {
            rna.dequeue();
            // we remove 3 elements because we count the dna sequence in 3's.
            rna.dequeue();
            rna.dequeue();
            return translateRNA(rna);
        }
    }
}