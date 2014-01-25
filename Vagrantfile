# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

PROVISION_SCRIPT = <<END

apt-get update
apt-get install -y git curl

if ! [ -d /usr/local/rvm ]; then
    curl -L https://get.rvm.io | bash -s stable --ruby=2.1.0

    echo "" >> /etc/bashrc
    echo "source /usr/local/rvm/scripts/rvm" >> /etc/bashrc
fi

if ! [ /usr/local/rvm/gems/ruby-2.1.0/bin/bundle ]; then
    gem install bundler
fi

cd /home/vagrant/poker-croupier && bundle install

END

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "precise64"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"

  config.vm.provision :shell, :inline => PROVISION_SCRIPT

  config.vm.synced_folder ".", "/home/vagrant/poker-croupier"
end
