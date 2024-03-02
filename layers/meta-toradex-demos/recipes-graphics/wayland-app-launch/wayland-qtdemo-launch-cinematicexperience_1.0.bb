# /home/hareendran/oe-core/layers/meta-toradex-demos/recipes-graphics/wayland-app-launch/wayland-qtdemo-launch-cinematicexperience_1.0.bb

# set the following variable to your one and only application which should
# be launched right after weston started

INITIAL_APP_PKGS ?= "cinematicexperience qtwayland"
APPLICATION_ENVIRONMENT ?= 'QT_QPA_PLATFORM=wayland-egl'
WAYLAND_APPLICATION ?= "/opt/SerialDataAcquisition/bin/SerialDataAcquisition --fullscreen"
# WAYLAND_APPLICATION ?= "/usr/share/cinematicexperience-1.0/Qt5_CinematicExperience --fullscreen"

require wayland-app-launch.inc
