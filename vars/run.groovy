def after(Map args, Closure closure) {
  sh script: args.setup
  closure()
}
