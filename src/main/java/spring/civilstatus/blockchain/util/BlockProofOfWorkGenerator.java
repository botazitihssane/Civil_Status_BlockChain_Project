package spring.civilstatus.blockchain.util;
import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;
/**
 * A Proof of Work algorithm (PoW) is how new Blocks are created or mined on the
 * blockchain. The goal of PoW is to discover a number which solves a problem.
 * The number must be difficult to find but easy to verify—computationally
 * speaking—by anyone on the network. This is the core idea behind Proof of
 * Work.
 */
public class BlockProofOfWorkGenerator {
	public static String PROOF_OF_WORK = "0000";

	public static Long proofOfWork(Long lastProof) {

		Long proof = 0L;

		while (validProof(lastProof, proof) != true)
			proof += 1L;

		return proof;
	}

	public static boolean validProof(Long lastProof, Long proof) {

		String s = "" + lastProof + "" + proof;

		String sha256 = Hashing.sha256().hashString(s, StandardCharsets.UTF_8).toString();

		return sha256.endsWith(PROOF_OF_WORK);
	}
}
