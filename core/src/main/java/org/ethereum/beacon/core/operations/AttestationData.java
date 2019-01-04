package org.ethereum.beacon.core.operations;

import tech.pegasys.artemis.ethereum.core.Hash32;
import tech.pegasys.artemis.util.uint.UInt64;

public class AttestationData {
  private final UInt64 slot;
  private final UInt64 shard;
  private final Hash32 beaconBlockRoot;
  private final Hash32 epochBoundaryRoot;
  private final Hash32 shardBlockRoot;
  private final Hash32 latestCrosslinkRoot;
  private final UInt64 justifiedSlot;
  private final Hash32 justifiedBlockRoot;

  public AttestationData(
      UInt64 slot,
      UInt64 shard,
      Hash32 beaconBlockRoot,
      Hash32 epochBoundaryRoot,
      Hash32 shardBlockRoot,
      Hash32 latestCrosslinkRoot,
      UInt64 justifiedSlot,
      Hash32 justifiedBlockRoot) {
    this.slot = slot;
    this.shard = shard;
    this.beaconBlockRoot = beaconBlockRoot;
    this.epochBoundaryRoot = epochBoundaryRoot;
    this.shardBlockRoot = shardBlockRoot;
    this.latestCrosslinkRoot = latestCrosslinkRoot;
    this.justifiedSlot = justifiedSlot;
    this.justifiedBlockRoot = justifiedBlockRoot;
  }

  public UInt64 getSlot() {
    return slot;
  }

  public UInt64 getShard() {
    return shard;
  }

  public Hash32 getBeaconBlockRoot() {
    return beaconBlockRoot;
  }

  public Hash32 getEpochBoundaryRoot() {
    return epochBoundaryRoot;
  }

  public Hash32 getShardBlockRoot() {
    return shardBlockRoot;
  }

  public Hash32 getLatestCrosslinkRoot() {
    return latestCrosslinkRoot;
  }

  public UInt64 getJustifiedSlot() {
    return justifiedSlot;
  }

  public Hash32 getJustifiedBlockRoot() {
    return justifiedBlockRoot;
  }
}