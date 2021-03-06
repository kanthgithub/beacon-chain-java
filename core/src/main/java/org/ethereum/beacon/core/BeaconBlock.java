package org.ethereum.beacon.core;

import tech.pegasys.artemis.ethereum.core.Hash32;
import tech.pegasys.artemis.util.bytes.Bytes96;
import tech.pegasys.artemis.util.uint.UInt64;

/**
 * Beacon chain block.
 *
 * <p>It consists of a header fields and {@link BeaconBlockBody}.
 *
 * @see BeaconBlockBody
 * @see <a
 *     href="https://github.com/ethereum/eth2.0-specs/blob/master/specs/core/0_beacon-chain.md#beaconblock">BeaconBlock
 *     in the spec</a>
 */
public class BeaconBlock implements Hashable {

  /** Number of a slot that block does belong to. */
  private final UInt64 slot;
  /** A hash of parent block. */
  private final Hash32 parentRoot;
  /** A hash of the state that is created by applying a block to the previous state. */
  private final Hash32 stateRoot;
  /** An image of RANDAO hash onion revealed by proposer. */
  private final Hash32 randaoReveal;
  /** Receipt root from the PoW chain registration contract that is observed by proposer. */
  private final Hash32 candidatePowReceiptRoot;
  /** Proposer's signature. */
  private final Bytes96 signature;

  /** Block body. */
  private final BeaconBlockBody body;

  public BeaconBlock(
      UInt64 slot,
      Hash32 parentRoot,
      Hash32 stateRoot,
      Hash32 randaoReveal,
      Hash32 candidatePowReceiptRoot,
      Bytes96 signature,
      BeaconBlockBody body) {
    this.slot = slot;
    this.parentRoot = parentRoot;
    this.stateRoot = stateRoot;
    this.randaoReveal = randaoReveal;
    this.candidatePowReceiptRoot = candidatePowReceiptRoot;
    this.signature = signature;
    this.body = body;
  }

  public boolean isParentOf(BeaconBlock other) {
    return true;
  }

  public BeaconBlock withStateRoot(Hash32 stateRoot) {
    return new BeaconBlock(
        slot, parentRoot, stateRoot, randaoReveal, candidatePowReceiptRoot, signature, body);
  }

  public UInt64 getSlot() {
    return slot;
  }

  public Hash32 getParentRoot() {
    return parentRoot;
  }

  public Hash32 getStateRoot() {
    return stateRoot;
  }

  public Hash32 getRandaoReveal() {
    return randaoReveal;
  }

  public Hash32 getCandidatePowReceiptRoot() {
    return candidatePowReceiptRoot;
  }

  public Bytes96 getSignature() {
    return signature;
  }

  public BeaconBlockBody getBody() {
    return body;
  }

  @Override
  public Hash32 getHash() {
    return Hash32.ZERO;
  }
}
