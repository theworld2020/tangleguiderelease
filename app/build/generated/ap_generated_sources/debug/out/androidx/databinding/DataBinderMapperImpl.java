package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new openai.chatgpt.guide.view.DataBinderMapperImpl());
  }
}
