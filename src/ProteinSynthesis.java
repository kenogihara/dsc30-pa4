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
        boolean startTranscription = false;
        if (rna.isEmpty()) {
            return emptyQueue;
        }
        String codon = "";
        MyQueue<Character> aminoAcidChain = new MyQueue<>();
        int group = rna.size() / GROUP;
        while (!rna.isEmpty()) {
            codon = rna.dequeue() + "" + rna.dequeue() + "" + rna.dequeue();
            if (codon.equals("AUG")) {
                startTranscription = true;
            }
            if (startTranscription) {
                if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
                    aminoAcidChain.enqueue(CodonMap.getAminoAcid(codon));
                    break;
                } else {
                    aminoAcidChain.enqueue(CodonMap.getAminoAcid(codon));
                }
            }
        }
        return aminoAcidChain;
    }
}