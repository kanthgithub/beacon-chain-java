package org.ethereum.beacon.core;

import static java.util.Collections.emptyList;

import java.util.List;
import org.ethereum.beacon.core.operations.Attestation;
import org.ethereum.beacon.core.operations.CasperSlashing;
import org.ethereum.beacon.core.operations.Deposit;
import org.ethereum.beacon.core.operations.Exit;
import org.ethereum.beacon.core.operations.ProofOfCustodyChallenge;
import org.ethereum.beacon.core.operations.ProofOfCustodyResponse;
import org.ethereum.beacon.core.operations.ProofOfCustodySeedChange;
import org.ethereum.beacon.core.operations.ProposerSlashing;

/**
 * Beacon block body.
 *
 * <p>Contains lists of beacon chain operations.
 *
 * @see BeaconBlock
 * @see <a
 *     href="https://github.com/ethereum/eth2.0-specs/blob/master/specs/core/0_beacon-chain.md#beaconblockbody">BeaconBlockBody
 *     in the spec</a>
 */
public class BeaconBlockBody {

  /** A body where all lists are empty. */
  public static final BeaconBlockBody EMPTY =
      new BeaconBlockBody(
          emptyList(),
          emptyList(),
          emptyList(),
          emptyList(),
          emptyList(),
          emptyList(),
          emptyList(),
          emptyList());

  /** A list of proposer slashing challenges. */
  private final List<ProposerSlashing> proposerSlashings;
  /** A list of Casper slashing challenges. */
  private final List<CasperSlashing> casperSlashings;
  /** A list of attestations. */
  private final List<Attestation> attestations;
  /** A list of proof of custody seed changes. */
  private final List<ProofOfCustodySeedChange> pocSeedChanges;
  /** A list of proof of custody challenges. */
  private final List<ProofOfCustodyChallenge> pocChallenges;
  /** A list of proof of custody challenge responses. */
  private final List<ProofOfCustodyResponse> pocResponses;
  /** A list of validator deposit proofs. */
  private final List<Deposit> deposits;
  /** A list of validator exits. */
  private final List<Exit> exits;

  public BeaconBlockBody(
      List<ProposerSlashing> proposerSlashings,
      List<CasperSlashing> casperSlashings,
      List<Attestation> attestations,
      List<ProofOfCustodySeedChange> pocSeedChanges,
      List<ProofOfCustodyChallenge> pocChallenges,
      List<ProofOfCustodyResponse> pocResponses,
      List<Deposit> deposits,
      List<Exit> exits) {
    this.proposerSlashings = proposerSlashings;
    this.casperSlashings = casperSlashings;
    this.attestations = attestations;
    this.pocSeedChanges = pocSeedChanges;
    this.pocChallenges = pocChallenges;
    this.pocResponses = pocResponses;
    this.deposits = deposits;
    this.exits = exits;
  }

  public List<ProposerSlashing> getProposerSlashings() {
    return proposerSlashings;
  }

  public List<CasperSlashing> getCasperSlashings() {
    return casperSlashings;
  }

  public List<Attestation> getAttestations() {
    return attestations;
  }

  public List<ProofOfCustodySeedChange> getPocSeedChanges() {
    return pocSeedChanges;
  }

  public List<ProofOfCustodyChallenge> getPocChallenges() {
    return pocChallenges;
  }

  public List<ProofOfCustodyResponse> getPocResponses() {
    return pocResponses;
  }

  public List<Deposit> getDeposits() {
    return deposits;
  }

  public List<Exit> getExits() {
    return exits;
  }
}
