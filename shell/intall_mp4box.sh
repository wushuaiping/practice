yum install git -y
yum install -y zlib zlib-devel

git clone --branch v0.8.0 https://github.com/gpac/gpac --depth=1
cd gpac/
chmod +x configure
./configure --static-mp4box
make -j20
make&make install
