package decoder.mpm;


import core.exception.PresentedModeException;
import core.model.mpm.TagLengthString;
import core.utils.TLVUtils;

// @formatter:off
public final class TagLengthStringDecoder extends DecoderMpm<TagLengthString> {

  public TagLengthStringDecoder(final String source) {
    super(source);
  }

  @Override
  protected TagLengthString decode() throws PresentedModeException {
    final TagLengthString result = new TagLengthString();

    while(iterator.hasNext()) {
      final String value = iterator.next();
      result.setTag(TLVUtils.valueOfTag(value));
      result.setValue(TLVUtils.valueOf(value));
    }

    return result;
  }

}

// @formatter:on
