
$:.push('lib/api')

require 'thrift'
require 'player_strategy'

require_relative 'lib/player_strategy_handler'

port = ARGV[1]

processor = API::PlayerStrategy::Processor.new(PlayerStrategyHandler.new())
transport = Thrift::ServerSocket.new(port)
server = Thrift::ThreadPoolServer.new(processor, transport)
server.serve()