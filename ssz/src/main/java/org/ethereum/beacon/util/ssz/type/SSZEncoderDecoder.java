package org.ethereum.beacon.util.ssz.type;

import net.consensys.cava.ssz.BytesSSZReaderProxy;
import org.ethereum.beacon.util.ssz.SSZSchemeBuilder;
import org.ethereum.beacon.util.ssz.SSZSerializer;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

/**
 * <p>Used for encoding and decoding of SSZ data (restoring instance of class)</p>
 * <p>For more information check {@link SSZSerializer}</p>
 */
public interface SSZEncoderDecoder {

  Set<String> getSupportedTypes();

  Set<Class> getSupportedClassTypes();

  void encode(Object value, SSZSchemeBuilder.SSZScheme.SSZField field, OutputStream result);

  void encodeList(List<Object> value, SSZSchemeBuilder.SSZScheme.SSZField field, OutputStream result);

  Object decode(SSZSchemeBuilder.SSZScheme.SSZField field, BytesSSZReaderProxy reader);

  List<Object> decodeList(SSZSchemeBuilder.SSZScheme.SSZField field, BytesSSZReaderProxy reader);

  default void registerIn(SSZSerializer serializer) {
    serializer.registerClassTypes(getSupportedClassTypes(), this);
    serializer.registerTypes(getSupportedTypes(), this);
  }

  default Object throwUnsupportedType(SSZSchemeBuilder.SSZScheme.SSZField field) throws RuntimeException {
    throw new RuntimeException(String.format("Type [%s] is not supported", field.type));
  }

  default List<Object> throwUnsupportedListType(SSZSchemeBuilder.SSZScheme.SSZField field) throws RuntimeException {
    throw new RuntimeException(String.format("List of types [%s] is not supported", field.type));
  }
}