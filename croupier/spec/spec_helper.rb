$:.push(File.join(File.dirname(__FILE__), '../../common/lib'))
$:.push(File.join(File.dirname(__FILE__)))

require_relative '../croupier'

module SpecHelper
  autoload :DummyClass, 'spec_helper/dummy_class'
  autoload :FakePlayer, 'spec_helper/fake_player'
  autoload :MakeGameState, 'spec_helper/make_game_state'
end
