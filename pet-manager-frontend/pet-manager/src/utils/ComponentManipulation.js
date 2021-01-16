export const addExtraProps = (Component, extraProps) => {
  return <Component.type {...Component.props} {...extraProps} />;
};
