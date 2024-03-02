# /home/hareendran/oe-core/layers/meta-toradex-demos/recipes-graphics/wayland-app-launch/wayland-qtdemo-launch-cinematicexperience_1.0.bb

SUMMARY = "Packagegroups which provide graphical/display/multimedia releated packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    packagegroup-drm-utils-tdx-graphical \
    packagegroup-gpu-tdx-graphical \
    packagegroup-x11-components-tdx-graphical \
    packagegroup-x11-utils-tdx-graphical \
"

RRECOMMENDS:packagegroup-tdx-graphical = " \
    packagegroup-gpu-tdx-graphical \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES', 'x11', \
                         'packagegroup-x11-components-tdx-graphical \
                          packagegroup-x11-utils-tdx-graphical', \
                         '', d), d)} \
"
RRECOMMENDS:packagegroup-tdx-graphical:append:am62xx = " \
    packagegroup-drm-utils-tdx-graphical \
"
RRECOMMENDS:packagegroup-tdx-graphical:append:mx8-nxp-bsp = " \
    packagegroup-drm-utils-tdx-graphical \
"
RRECOMMENDS:packagegroup-tdx-graphical:append:upstream = " \
    packagegroup-drm-utils-tdx-graphical \
"

SUMMARY:packagegroup-drm-utils-tdx-graphical = "Utilities for DRM, Direct Rendering Manager"
RRECOMMENDS:packagegroup-drm-utils-tdx-graphical = " \
    libdrm-tests \
"

SUMMARY:packagegroup-gpu-utils-tdx-graphical = "Utilities for GPU (OpenGL...)"
IMAGE_INSTALL_OPENCL_IMX = " \
    clpeak \
    libopencl-imx \
"
RRECOMMENDS:packagegroup-gpu-tdx-graphical = " \
    glmark2 \
"
IMAGE_INSTALL_GPU_MX6QDL = " \
    packagegroup-fsl-gpu-libs \
"
RRECOMMENDS:packagegroup-gpu-tdx-graphical:append:mx6dl-nxp-bsp = " \
    ${IMAGE_INSTALL_GPU_MX6QDL} \
"
RRECOMMENDS:packagegroup-gpu-tdx-graphical:append:mx6q-nxp-bsp = " \
    ${IMAGE_INSTALL_GPU_MX6QDL} \
    ${IMAGE_INSTALL_OPENCL_IMX} \
"
RRECOMMENDS:packagegroup-gpu-tdx-graphical:colibri-imx6ull = ""
RRECOMMENDS:packagegroup-gpu-tdx-graphical:colibri-imx6ull-emmc = ""
RRECOMMENDS:packagegroup-gpu-tdx-graphical:append:mx8-nxp-bsp = " \
    tinycompress \
    libvdk-imx \
    vulkan-headers \
    vulkan-loader \
    vulkan-tools \
    ${IMAGE_INSTALL_OPENCL_IMX} \
"
RRECOMMENDS:packagegroup-gpu-tdx-graphical:remove:mx8mm-nxp-bsp = " \
    vulkan \
    ${IMAGE_INSTALL_OPENCL_IMX} \
"
RRECOMMENDS:packagegroup-gpu-tdx-graphical:append:mx8qm-nxp-bsp = " \
    libopenvx-imx \
"

SUMMARY:packagegroup-x11-components-tdx-graphical = "Components of X11"
RRECOMMENDS:packagegroup-x11-components-tdx-graphical = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES', 'x11', \
       'libxcursor \
        libxdamage \
        libxres \
        libxvmc \
        xcursor-transparent-theme \
        xorg-minimal-fonts \
        xrdb \
        xserver-xorg-extension-dbe \
        xserver-xorg-extension-extmod \
        xserver-xorg-multimedia-modules \
        xserver-xorg-utils', \
       '', d), d)} \
"

SUMMARY:packagegroup-x11-utils-tdx-graphical = "Utilities for X11"
RRECOMMENDS:packagegroup-x11-utils-tdx-graphical = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES', 'x11', \
       'scrot \
        setxkbmap \
        unclutter', \
       '', d), d)} \
"
